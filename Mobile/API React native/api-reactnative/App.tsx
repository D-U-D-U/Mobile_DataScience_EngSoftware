import { StatusBar } from 'expo-status-bar';
import React, { useEffect, useState } from 'react';
import {
  ActivityIndicator,
  Alert,
  FlatList,
  Image,
  SafeAreaView,
  StyleSheet,
  Text,
  TouchableOpacity,
  View,
} from 'react-native';

type Movie = {
  id: string;
  title: string;
  description: string;
  director?: string;
  release_date?: string;
  image?: string;
  movie_banner?: string;
};

export default function App() {
  const [movies, setMovies] = useState<Movie[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    const fetchMovies = async () => {
      try {
        setLoading(true);
        setError(null);
        const res = await fetch('https://ghibliapi.vercel.app/films');
        if (!res.ok) throw new Error(`HTTP ${res.status}`);
        const data = await res.json();
        setMovies(data || []);
      } catch (err: any) {
        setError(err.message || 'Failed to load movies');
      } finally {
        setLoading(false);
      }
    };

    fetchMovies();
  }, []);

  const onPressMovie = (movie: Movie) => {
    Alert.alert(movie.title, movie.description || 'No description available', [
      { text: 'Close', style: 'cancel' },
    ]);
  };

  const renderItem = ({ item }: { item: Movie }) => {
    const imageUri = item.image || item.movie_banner || undefined;
    return (
      <TouchableOpacity style={styles.item} onPress={() => onPressMovie(item)}>
        {imageUri ? (
          <Image source={{ uri: imageUri }} style={styles.poster} resizeMode="cover" />
        ) : (
          <View style={[styles.poster, styles.posterPlaceholder]} />
        )}
        <View style={styles.info}>
          <Text style={styles.title}>{item.title}</Text>
          <Text style={styles.subtitle}>{item.director} • {item.release_date}</Text>
          <Text style={styles.description} numberOfLines={3}>{item.description}</Text>
        </View>
      </TouchableOpacity>
    );
  };

  return (
    <SafeAreaView style={styles.container}>
      <StatusBar style="auto" />
      <Text style={styles.header}>Filmes — Catálogo (Ghibli API)</Text>
      {loading ? (
        <View style={styles.loadingContainer}>
          <ActivityIndicator size="large" />
          <Text style={styles.loadingText}>Carregando filmes...</Text>
        </View>
      ) : error ? (
        <View style={styles.loadingContainer}>
          <Text style={styles.errorText}>Erro: {error}</Text>
        </View>
      ) : (
        <FlatList
          data={movies}
          keyExtractor={(item) => item.id}
          renderItem={renderItem}
          contentContainerStyle={styles.list}
        />
      )}
    </SafeAreaView>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
  header: {
    fontSize: 18,
    fontWeight: '600',
    padding: 12,
    textAlign: 'center',
  },
  list: {
    paddingHorizontal: 12,
    paddingBottom: 24,
  },
  item: {
    flexDirection: 'row',
    marginVertical: 8,
    backgroundColor: '#f8f8f8',
    borderRadius: 8,
    overflow: 'hidden',
    elevation: 1,
  },
  poster: {
    width: 100,
    height: 140,
  },
  posterPlaceholder: {
    backgroundColor: '#ddd',
    alignItems: 'center',
    justifyContent: 'center',
  },
  info: {
    flex: 1,
    padding: 10,
    justifyContent: 'center',
  },
  title: {
    fontSize: 16,
    fontWeight: '700',
    marginBottom: 4,
  },
  subtitle: {
    fontSize: 12,
    color: '#666',
    marginBottom: 8,
  },
  description: {
    fontSize: 13,
    color: '#333',
  },
  loadingContainer: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  loadingText: {
    marginTop: 8,
    color: '#444',
  },
  errorText: {
    color: '#b00020',
  },
});
