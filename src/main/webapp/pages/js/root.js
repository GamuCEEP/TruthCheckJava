$ = (e, from = null) => from ? from.querySelector(e) : document.querySelector(e)
$$ = (e, from = null) => from ? from.querySelectorAll(e) : document.querySelectorAll(e) 


function show(e) {
  let id = e.startsWith('#') ? e : `#${e}`
  $(id).setAttribute('style', 'display: block')
}

function clearURL() {
  const currentURL = window.location.href.replace(window.location.search, '')
  window.history.replaceState({}, document.title, currentURL)
}

async function getUser() {
  return getData('/TruthCheckJava/w/user/logged')
}

async function getResourceTypes(){
  return getData('/TruthCheckJava/w/util/resourceTypes')
}

async function getData(url){
  const resp = await fetch(url)
  return resp.json()
}

async function putResources(container, filter = ''){
// Coje los recursos del servidor y los pone en el container
}



