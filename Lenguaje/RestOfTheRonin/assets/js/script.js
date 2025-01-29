// Obtener referencias al div y al botón
const div = document.getElementById("info");
const boton = document.getElementById("ocultar-btn");

// Agregar un evento click al botón
boton.addEventListener("click", function () {
  // Ocultar el div cambiando el estilo
  div.style.display = "none";
});