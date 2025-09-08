import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from sklearn.preprocessing import LabelEncoder, StandardScaler

df = pd.read_csv("Titanic.csv")

# 01 Tratamento de dados ausentes
df['Age'].fillna(df['Age'].median(), inplace=True)
df['Fare'].fillna(df['Fare'].mean(), inplace=True)
df['Embarked'].fillna(df['Embarked'].mode()[0], inplace=True)

# 02 Transformação de dados categóricos
le = LabelEncoder()
df['Sex'] = le.fit_transform(df['Sex'])  # male=1, female=0
df['Embarked'] = le.fit_transform(df['Embarked'])  # C=0, Q=1, S=2

# 03 Padronização de dados
scaler = StandardScaler()
df[['Age', 'Fare']] = scaler.fit_transform(df[['Age', 'Fare']])

# 04 Análise descritiva
print("Média:\n", df[['Age', 'Fare']].mean())
print("\nModa:\n", df[['Age', 'Fare']].mode().iloc[0])
print("\nMediana:\n", df[['Age', 'Fare']].median())
print("\nDesvio padrão:\n", df[['Age', 'Fare']].std())
print("\nFrequência de sobreviventes:\n", df['Survived'].value_counts(normalize=True))

# 05 Graficos
plt.figure(figsize=(14, 10))

# Gráfico de frequência relativa
plt.subplot(2, 3, 1)
df['Survived'].value_counts(normalize=True).plot(kind='bar', color=['skyblue', 'salmon'])
plt.title('Frequência relativa de sobrevivência')
plt.xticks([0, 1], ['Não sobreviveu', 'Sobreviveu'], rotation=0)

# Gráfico de dispersão
plt.subplot(2, 3, 2)
sns.scatterplot(x='Age', y='Fare', hue='Survived', data=df)
plt.title('Dispersão: Idade vs Tarifa')

# Histograma
plt.subplot(2, 3, 3)
df['Age'].plot(kind='hist', bins=30, color='purple', alpha=0.7)
plt.title('Distribuição de Idade')

# Gráfico de pizza
plt.subplot(2, 3, 4)
df['Pclass'].value_counts().plot(kind='pie', autopct='%1.1f%%', colors=['gold', 'lightgreen', 'lightcoral'])
plt.title('Distribuição por Classe')
plt.ylabel('')

# Boxplot
plt.subplot(2, 3, 5)
sns.boxplot(x='Pclass', y='Age', data=df)
plt.title('Dispersão de Idade por Classe')

plt.tight_layout()
plt.show()
