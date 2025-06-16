        // ANIMAÇÃO DO HEADER AO ROLAR
window.addEventListener('scroll', function() {
  const header = document.querySelector('.collapsing-header');
  const scrollY = window.scrollY;
  
  // Calcula valores intermediários
  const maxScroll = 200; // Ajuste conforme necessário
  const scrollPercent = Math.min(scrollY / maxScroll, 1);
  
  // Interpola entre os valores
  const height = 300 - (scrollPercent * 200); // De 300px a 100px
  const opacity = 1 - (scrollPercent * 0.3); // De 1 a 0.7
  
  header.style.height = `${height}px`;
  header.style.opacity = opacity;
});




function scrollCarousel(direction) {
  const carousel = document.getElementById('carouselInner');
  const scrollBy = 220; // pixels por clique
  carousel.scrollBy({ left: direction * scrollBy, behavior: 'smooth' });
}