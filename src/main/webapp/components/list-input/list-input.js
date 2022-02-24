

class ListInput extends HTMLElement {

  constructor() {
    super()
    self = this;
    // TODO hacer que el name funcione
    // Quizas no necesite hacer eso aqui
    // Parece responsabilidad del elemento duplicado
    // Podria hacer un cElement que interactue
    // Un metodo que se pueda llamar

    this.originalContetnt = Array.from(this.children)
    this.fields = 0

    const moreButton = document.createElement('button')
    const lessButton = document.createElement('button')
    const label = document.createElement('p')
    label.innerText = self.getAttribute('label')

    this.controls = document.createElement('div')
    this.controls.append(label, moreButton, lessButton)

    this.content = document.createElement('div')

    moreButton.innerText = '+'
    moreButton.setAttribute('type', 'button')
    moreButton.addEventListener('click', self.addField)
    lessButton.innerText = '-'
    lessButton.setAttribute('type', 'button')
    lessButton.addEventListener('click', self.deleteField)


    this.innerHTML = ''
    this.append(this.controls, this.content)
    this.addField()
    
  }
  addField() {
    const newContent = self.originalContetnt

    for(const originalChild of newContent){
      const child = originalChild.cloneNode()
      child.classList.add('class', 'inp'+self.fields)
      self.content.appendChild(child)

    }
    self.fields++
  }
  deleteField() {
    self.fields--
    const inp = self.querySelectorAll('.inp'+self.fields)
    for(const child of inp){
      self.content.removeChild(child)
    }
    if(self.fields < 0) self.fields = 0
  }
  connectedCallback() {
    if (!this.isConnected) return
    const css = document.head.querySelector("link[src$='list-input.css'")
    if (css != null) return
    const link = document.createElement('link')
    link.setAttribute('href', '/components/list-input/list-input.css')
    link.setAttribute('rel', 'stylesheet')
    document.head.append(link)
  }

}
customElements.define('list-input', ListInput)