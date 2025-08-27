document.getElementById('loadCats').addEventListener('click', () => {
  fetch('https://api.thecatapi.com/v1/images/search?limit=9')
    .then(response => response.json())
    .then(data => {
      const gallery = document.getElementById('gallery');
      gallery.innerHTML = '';
      data.forEach(cat => {
        const img = document.createElement('img');
        img.src = cat.url;
        gallery.appendChild(img);
      });
    })
    .catch(error => console.error('Erro ao carregar imagens:', error));
});
