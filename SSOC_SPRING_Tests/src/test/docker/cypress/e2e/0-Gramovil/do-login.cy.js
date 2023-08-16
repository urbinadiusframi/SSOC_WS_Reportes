/// <reference types="cypress" />

// Welcome to Cypress!
//
// This spec file contains a variety of sample tests
// for a todo list app that are designed to demonstrate
// the power of writing tests in Cypress.
//
// To learn more about how Cypress works and
// what makes it such an awesome testing tool,
// please read our getting started guide:
// https://on.cypress.io/introduction-to-cypress

describe('Gramovil tests', () => {
  beforeEach(() => {
    cy.login('ADMIN', '2244426')
  })

  it('navbar operativo', () => {
    // We use the `cy.get()` command to get all elements that match the selector.
    // Then, we use `should` to assert that there are two matched items,
    // which are the two default items.
    cy.get('#bs-example-navbar-collapse-1 > ul:nth-child(1) > li').should('have.length', 19)

    // We can go even further and check that the default todos each contain
    // the correct text. We use the `first` and `last` functions
    // to get just the first and last matched elements individually,
    // and then perform an assertion with `should`.
    cy.get(':nth-child(1) > :nth-child(8) > a').should('have.text', ' SAT ')
    cy.get(':nth-child(1) > :nth-child(8) > a').click()
    cy.get('body > div.container > div > div.panel-heading > h4').should('have.text', ' Buscar SAT')
    cy.get('.btn-group > .btn').should('have.text', ' Nueva SAT')
    cy.get('tbody > :nth-child(2) > :nth-child(1)')
      .invoke('text')
      .as('elementText')
    cy.get('@elementText').then((text) => {
      cy.get('.btn-group > .btn').click()
      cy.get('.panel-heading > h4').should('have.text', ' Nueva SAT')
      cy.get('#imei_dispositivo').type(`12`)
      cy.get('#ui-id-3').should('contain.text', 'IMEI:')
      cy.get('#ui-id-3').click()
      cy.get('#nombre_cliente').should('have.attr', 'placeholder', 'Selecciona un cliente')
      cy.get('#nombre_cliente').type('12')
      cy.get('#ui-id-1').should('contain.text', '12')
      cy.get('#ui-id-1').click()
      cy.get('#telefono_cliente').invoke('val').should('eq', '12')
      //Agregar piezas
      cy.get('[data-target="#agregarPiezas"]').should('contain.text', 'Agregar piezas')
      cy.get('[data-target="#agregarPiezas"]').click()
      cy.get('tbody > :nth-child(8) > :nth-child(1)').should('have.text', '689')
      cy.get('#descuento_689').clear()
      cy.get('#descuento_689').clear()
      cy.get('#descuento_689').clear()
      cy.get('#descuento_689').type('1')
      cy.get('#precio_689').invoke('val').should('eq', '2')
      cy.get('#descuento_689').invoke('val').should('eq', '1')
      cy.get('.text-right > .btn > .glyphicon').click()
      cy.get('#resultados_nuevo_piezas > .table > tbody > tr').should('have.length', 3)
      cy.get('#resultados_nuevo_piezas > .table > tbody > :nth-child(2) > :nth-child(1)').should('have.text', '1')
      cy.get('#resultados_nuevo_piezas > .table > tbody > :nth-child(2) > :nth-child(2)').should('have.text', 'Altavoz')
      cy.get('#resultados_nuevo_piezas > .table > tbody > :nth-child(3) > :nth-child(2)').should('have.text', '1.00')
      cy.get('#agregarPiezas > .modal-dialog > .modal-content > .modal-footer > .btn').click()
      //fin Agregar piezas
      //Agregar reparacion
      cy.get('[data-target="#myModal"]').should('contain.text', 'Agregar reparaciones')
      cy.get('[data-target="#myModal"]').click()
      cy.get('.outer_div > .table-responsive > .table > tbody > :nth-child(2) > :nth-child(1)').should('have.text', '1')
      cy.get('.outer_div > .table-responsive > .table > tbody > :nth-child(2) > :nth-child(2)').should('have.text', '1')
      cy.get('.outer_div > .table-responsive > .table > tbody > :nth-child(2) > :nth-child(3)').should('have.text', 'Mojado')
      cy.get('#precio_1').clear()
      cy.get('#precio_1').clear()
      cy.get('#precio_1').clear()
      cy.get('#precio_1').type('2')
      cy.get('#descuento_1').clear()
      cy.get('#descuento_1').clear()
      cy.get('#descuento_1').clear()
      cy.get('#descuento_1').type('1')
      cy.get('#precio_1').invoke('val').should('eq', '2')
      cy.get('#descuento_1').invoke('val').should('eq', '1')
      cy.get(':nth-child(2) > .text-center > .btn').click()
      cy.get('#resultados_nuevo > .table > tbody > tr').should('have.length', 3)
      cy.get('#resultados_nuevo > .table > tbody > :nth-child(2) > :nth-child(1)').should('have.text', '1')
      cy.get('#resultados_nuevo > .table > tbody > :nth-child(2) > :nth-child(2)').should('have.text', 'Mojado')
      cy.get('#resultados_nuevo > .table > tbody > :nth-child(2) > :nth-child(6)').should('have.text', '1.00')
      cy.get('#resultados_nuevo > .table > tbody > :nth-child(3) > :nth-child(2)').should('have.text', '1.00')
      cy.get('#myModal > .modal-dialog > .modal-content > .modal-footer > .btn').click()
      //fin Agregar reparacion
      cy.get('#total_nueva_sat > :nth-child(3)').scrollIntoView()
      cy.get('#total_nueva_sat > :nth-child(3)').should('have.text', '2.00')

      cy.get('.pull-right > [type="submit"]').should('contain.text', 'Imprimir')
      cy.get('.pull-right > [type="submit"]').click()
      cy.wait(3000)
      cy.window().then((win) => {
        win.scroll({
          top: document.body.scrollHeight,
          left: 0,
          behavior: 'smooth'
        });
      });
      cy.wait(3000)
      cy.visit('/');
      cy.get(':nth-child(1) > :nth-child(8) > a').click()
      cy.get('tbody > :nth-child(2) > :nth-child(1)').should('have.text', text.trim().split('-')[0] + '-' + (new Number(text.trim().split('-')[1]) + 1))
      cy.get(':nth-child(2) > .text-right > a').should('have.length', 3)
      cy.get('body > div.container > div > div.panel-body > div.outer_div > div > table > tbody > tr:nth-child(2) > td.text-right > a:nth-child(1)').should('have.attr', 'title', 'Editar factura')
      cy.get('body > div.container > div > div.panel-body > div.outer_div > div > table > tbody > tr:nth-child(2) > td.text-right > a:nth-child(1)').click()
      cy.get('#resultados_editar_piezas > .table > tbody > :nth-child(4) > :nth-child(2)').scrollIntoView()
      cy.get('#resultados_editar_piezas > .table > tbody > :nth-child(4) > :nth-child(2)').should('have.text', '2.00')

    })

  })

  // it('can add new todo items', () => {
  //   // We'll store our item text in a variable so we can reuse it
  //   const newItem = 'Feed the cat'

  //   // Let's get the input element and use the `type` command to
  //   // input our new list item. After typing the content of our item,
  //   // we need to type the enter key as well in order to submit the input.
  //   // This input has a data-test attribute so we'll use that to select the
  //   // element in accordance with best practices:
  //   // https://on.cypress.io/selecting-elements
  //   cy.get('[data-test=new-todo]').type(`${newItem}{enter}`)

  //   // Now that we've typed our new item, let's check that it actually was added to the list.
  //   // Since it's the newest item, it should exist as the last element in the list.
  //   // In addition, with the two default items, we should have a total of 3 elements in the list.
  //   // Since assertions yield the element that was asserted on,
  //   // we can chain both of these assertions together into a single statement.
  //   cy.get('.todo-list li')
  //     .should('have.length', 3)
  //     .last()
  //     .should('have.text', newItem)
  // })

  // it('can check off an item as completed', () => {
  //   // In addition to using the `get` command to get an element by selector,
  //   // we can also use the `contains` command to get an element by its contents.
  //   // However, this will yield the <label>, which is lowest-level element that contains the text.
  //   // In order to check the item, we'll find the <input> element for this <label>
  //   // by traversing up the dom to the parent element. From there, we can `find`
  //   // the child checkbox <input> element and use the `check` command to check it.
  //   cy.contains('Pay electric bill')
  //     .parent()
  //     .find('input[type=checkbox]')
  //     .check()

  //   // Now that we've checked the button, we can go ahead and make sure
  //   // that the list element is now marked as completed.
  //   // Again we'll use `contains` to find the <label> element and then use the `parents` command
  //   // to traverse multiple levels up the dom until we find the corresponding <li> element.
  //   // Once we get that element, we can assert that it has the completed class.
  //   cy.contains('Pay electric bill')
  //     .parents('li')
  //     .should('have.class', 'completed')
  // })

  // context('with a checked task', () => {
  //   beforeEach(() => {
  //     // We'll take the command we used above to check off an element
  //     // Since we want to perform multiple tests that start with checking
  //     // one element, we put it in the beforeEach hook
  //     // so that it runs at the start of every test.
  //     cy.contains('Pay electric bill')
  //       .parent()
  //       .find('input[type=checkbox]')
  //       .check()
  //   })

  //   it('can filter for uncompleted tasks', () => {
  //     // We'll click on the "active" button in order to
  //     // display only incomplete items
  //     cy.contains('Active').click()

  //     // After filtering, we can assert that there is only the one
  //     // incomplete item in the list.
  //     cy.get('.todo-list li')
  //       .should('have.length', 1)
  //       .first()
  //       .should('have.text', 'Walk the dog')

  //     // For good measure, let's also assert that the task we checked off
  //     // does not exist on the page.
  //     cy.contains('Pay electric bill').should('not.exist')
  //   })

  //   it('can filter for completed tasks', () => {
  //     // We can perform similar steps as the test above to ensure
  //     // that only completed tasks are shown
  //     cy.contains('Completed').click()

  //     cy.get('.todo-list li')
  //       .should('have.length', 1)
  //       .first()
  //       .should('have.text', 'Pay electric bill')

  //     cy.contains('Walk the dog').should('not.exist')
  //   })

  //   it('can delete all completed tasks', () => {
  //     // First, let's click the "Clear completed" button
  //     // `contains` is actually serving two purposes here.
  //     // First, it's ensuring that the button exists within the dom.
  //     // This button only appears when at least one task is checked
  //     // so this command is implicitly verifying that it does exist.
  //     // Second, it selects the button so we can click it.
  //     cy.contains('Clear completed').click()

  //     // Then we can make sure that there is only one element
  //     // in the list and our element does not exist
  //     cy.get('.todo-list li')
  //       .should('have.length', 1)
  //       .should('not.have.text', 'Pay electric bill')

  //     // Finally, make sure that the clear button no longer exists.
  //     cy.contains('Clear completed').should('not.exist')
  //   })
  // })
})
