if ('serviceWorker' in navigator) {
  window.addEventListener('load', () => {
    registerSW('../sw.js');
  })
}

async function registerSW(src) {
  const registration = await navigator.serviceWorker.register(src)

  if (!registration) {
    console.log("Error al registrar el SW")
    return;
  }

  await registration.update()
  console.log("Registrado correctamente", registration.scope)

}

