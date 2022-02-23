$$ = e => document.querySelectorAll(e)
$ = e => document.querySelector(e)
;
(() => {
  window.addEventListener('load', () => {
    let inputNumber = 0
    const mapInputs = $$('.mapInput')

    for (const mapInput of mapInputs) {
      const addButton = document.createElement('button')
      addButton.innerText = '+'
      addButton.type = 'button'



      const subButton = document.createElement('button')
      subButton.innerText = '-'
      subButton.type = 'button'

      const controls = document.createElement('div')
      controls.classList.add('controls')

      const inputs = document.createElement('div')
      inputs.classList.add('inputs')

      controls.appendChild(addButton)
      controls.appendChild(subButton)

      mapInput.appendChild(controls)
      mapInput.appendChild(inputs)

      addButton.addEventListener('click', () => {
        inputNumber++
        const mapKey = document.createElement('input')
        mapKey.placeholder = 'Estadistica'
        mapKey.classList.add('inp'+inputNumber)
        mapKey.name = 'mapkey'
        mapKey.required = true

        const mapValue = document.createElement('input')
        mapValue.placeholder = 'Valor'
        mapValue.classList.add('inp'+inputNumber)

        inputs.appendChild(mapKey)
        inputs.appendChild(mapValue)


        mapKey.addEventListener('input', () => {
          mapValue.name = mapKey.value
        })
      })
      subButton.addEventListener('click', () => {
        const delinputs = $$('.inp'+inputNumber)
        for(const delinput of delinputs){
          inputs.removeChild(delinput)
        }
        inputNumber--
        if(inputNumber < 0) inputNumber = 0
      })

    }

  })

})()

