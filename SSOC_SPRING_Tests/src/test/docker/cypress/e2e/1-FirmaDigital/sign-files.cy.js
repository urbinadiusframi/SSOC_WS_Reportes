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

describe('Firma digital', () => {
  beforeEach(() => {
    cy.visit('https://dev-servicios-dmz.supersociedades.gov.co:1446/FrontFirma/signer?idApp=10&idUser=10')
  })

  it('navbar operativo', () => {
    // We use the `cy.get()` command to get all elements that match the selector.
    // Then, we use `should` to assert that there are two matched items,
    // which are the two default items.
    cy.get('.thead-dark > tr > :nth-child(1)').should('have.text', 'Nombre de archivo')
    cy.get('.thead-dark > tr > :nth-child(2)').should('have.text', 'Firmar')
    cy.get('tbody > tr').should('have.length', 2)
    cy.get(':nth-child(1) > :nth-child(2) > .form-check > .form-check-input').click()
    cy.get('.col-6').click()

  })
})
