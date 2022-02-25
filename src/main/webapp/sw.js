

self.addEventListener('fetch', mockResponse)

function mockResponse(event){
  const resp = new Response()

  resp.

  event.respondWith('Hola')
  console.log('te he pillado')
}