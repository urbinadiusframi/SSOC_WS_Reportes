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

describe('Generar Producción Documental', () => {
  beforeEach(() => {
    cy.loginSSOCDllo('UserSGDEA1', 'Agosto2023*')
  })

  it('navbar operativo', () => {
    cy.get('[ng-hide="hideServices && hideProcesses"] > .menu-heading > .filter > .form-group > .form-control').type('Generar Producción Documental')
    cy.get('#collapseLaunchsMenu > .menu-list > [style=""]').should('contain.text', 'Generar Producción Documental')
    cy.get('#collapseLaunchsMenu > .menu-list > [style=""]').click()

    cy.get('#div_6_1 > iframe', { timeout: 90000 }).then(iframe => {
      iframe.get('#collapseLaunchsMenu > .menu-list > [style=""]').click()
    });


  })
})
