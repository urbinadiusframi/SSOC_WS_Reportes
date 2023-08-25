/// <reference types="cypress" />
import "cypress-iframe";


describe('Generar Producción Documental', () => {
  beforeEach(() => {
    cy.loginSSOCDllo('UserSGDEA1', 'Agosto2023*')
  })

  it('navbar operativo', () => {
    
    cy.get('#collapseLaunchsMenu > div').children('div').should('have.length.gt', 1)
    cy.get(':nth-child(6) > #launch-menu-item-icon-service > :nth-child(1) > .menu-link-body > a.ng-binding').should('contain.text', 'Generar Producción Documental')
    cy.intercept('GET', 'https://dev-servicios-dmz.supersociedades.gov.co:1444/ConsultaTerceros/*').as('specificXhr');
    cy.get(':nth-child(6) > #launch-menu-item-icon-service > :nth-child(1) > .menu-link-body > a.ng-binding').click()
    cy.wait(10000)
      cy.wait('@specificXhr').then(() => {
      cy.get('.name > a').should('contain.text', 'Generar Producción Documental')
      // cy.intercept('GET', '**').as('associatedRequests');
      // cy.wait('@associatedRequests');
      // cy.get('#dropdownForm1').should('contain.text', 'Seleccione un tipo de identificación')
      // cy.get('#dropdownForm1').click()
    });
  })
})
