
; (() => {
  const retractButtons = $$('.retract-button')
  for (const button of retractButtons) {
    const pannel = button.parentNode
    let a = 'extended'
    let b = 'retracted'
    button.addEventListener('click', () => {
      pannel.classList.replace(a, b)
        ;[a, b] = [b, a] //Swap
    })
  }
})()