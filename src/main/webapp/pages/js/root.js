$ = e => document.querySelector(e)
$$ = e => document.querySelectorAll(e)


function show(e){
  let id = e.startsWith('#') ? e : `#${e}`
  $(id).setAttribute('style', 'display: block')
}

function clearURL(){
  const currentURL = window.location.href.replace(window.location.search,'' )
  window.history.replaceState({}, document.title,currentURL)
}