

// Se inserta en el body el modal
// el modal tiene un cover, que tapa el fondo con opacidad
// y un modal que contiene lo que se quiera mostrar
// lo que se quiera mostrar es una template 
// externa al documento
// todo el modal debe estar en un solo div
// <div> modal </div>

const pathToModals = '/TruthCheckJava/pages/modals/'
let cover;
; (() => {
  if (!document.head.querySelector('link[href~="modal.css"')) {
    const css = document.createElement('link')
    css.setAttribute('rel', 'stylesheet')
    css.setAttribute('href', '/TruthCheckJava/components/modal/modal.css')
    document.head.append(css)
  }
})()

function attributeListToObj(attrList) {
  let res = {}
  for (const attr of attrList) {
    res[attr.name] = attr.value
  }
  return res
}


async function setModalButtons(from) {

  const modalContainer = $('#modalContainer')
  const modalBox = document.createElement('div')
  modalContainer.append(modalBox)
  modalBox.innerHTML = ''
  console.log(from)

  const buttons = $$('.modal-button', from)
  for (const button of buttons) {
    if (!button.hasAttribute('modal')) continue

    const modal = await getModal(button)
    modalBox.append(modal)
    evaluate(modal)

    function showModal() {
      hideModals()
      cover.removeAttribute('style')
      modal.removeAttribute('style')
    }

    button.removeEventListener('click', showModal)
    button.addEventListener('click', showModal)

  }
}

cover = createCover()
setModalButtons()

function createCover() {
  const cover = document.createElement('div')
  cover.classList.add('modal-cover')
  cover.setAttribute('style', 'display: none')

  const modalContainer = $('#modalContainer')
  modalContainer.append(cover)
  cover.addEventListener('click', () => {
    hideModals()
  })
  return cover
}

async function getModal(button) {
  const modalURL = pathToModals + button.getAttribute('modal') + '.template.html'
  const attributes = attributeListToObj(button.attributes)

  const modalTemplate = await getTemplate(modalURL, attributes)

  const modal = modalTemplate.content.firstElementChild.cloneNode(true)
  modal.setAttribute('style', 'display: none')
  modal.classList.add('modal')
  return modal
}

function hideModals() {
  for (const modal of $$('.modal', modalContainer)) {
    modal.setAttribute('style', 'display: none')
  }
  $('.modal-cover').setAttribute('style', 'display: none')
}

async function evaluate(modal) {
  const scripts = $$('script', modal)
  for (const script of scripts) {
    console.log(modal, script)
    await eval(script.innerText)
  }
}




