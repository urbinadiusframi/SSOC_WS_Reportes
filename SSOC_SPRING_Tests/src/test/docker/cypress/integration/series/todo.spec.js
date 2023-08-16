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

describe('MotorReglasApi', () => {
    beforeEach(() => {
        cy.visit('http://host.docker.internal:8084/swagger-ui.html')
        cy.get('#swagger-ui > section > div.swagger-ui > div:nth-child(2) > div:nth-child(5) > section > div').children().should('have.length', 5)
        cy.screenshot('swagger-instrumentos.png');
        cy.get('#operations-tag-instrumentos-archivisticos-controller').should('have.text', 'instrumentos-archivisticos-controllerInstrumentos Archivisticos Controller')
    })



    it('Bandeja de entrada', () => {
        cy.get('#operations-tag-instrumentos-archivisticos-controller').click()
        cy.get('#operations-instrumentos-archivisticos-controller-listarSeriesUsingGET > .opblock-summary').click()
        cy.get('.try-out > .btn').should('have.text', 'Try it out ').click()
        cy.get('input').type('Basic c3NvYy1hZG1pbi1pYTpQd2RfMzIx')
        cy.get('.parameters-col_description > select').select('true')
        cy.get('.execute-wrapper > .btn').should('have.text', 'Execute')
        cy.get('.execute-wrapper > .btn').click()
        cy.get(':nth-child(1) > .responses-table > tbody > .response > .response-col_status').should('have.text', '200')
        cy.screenshot('listar-series-ok.png');
    })

})
