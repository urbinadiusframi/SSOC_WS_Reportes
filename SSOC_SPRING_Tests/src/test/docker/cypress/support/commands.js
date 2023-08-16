// ***********************************************
// This example commands.js shows you how to
// create various custom commands and overwrite
// existing commands.
//
// For more comprehensive examples of custom
// commands please read more here:
// https://on.cypress.io/custom-commands
// ***********************************************
//
//
// -- This is a parent command --
// Cypress.Commands.add('login', (email, password) => { ... })
//
//
// -- This is a child command --
// Cypress.Commands.add('drag', { prevSubject: 'element'}, (subject, options) => { ... })
//
//
// -- This is a dual command --
// Cypress.Commands.add('dismiss', { prevSubject: 'optional'}, (subject, options) => { ... })
//
//
// -- This will overwrite an existing command --
// Cypress.Commands.overwrite('visit', (originalFn, url, options) => { ... })

// cypress/support/e2e.js

Cypress.Commands.add('login', (username, password) => {
  // Logic to perform login
  cy.visit('/login');
  cy.get('#user_name').type(username);
  cy.get('#user_password').type(password);
  cy.get('button[type="submit"]').click();
});

Cypress.Commands.add('loginSSOCDllo', (username, password) => {
  // Logic to perform login
  cy.visit('/');
  cy.get('#providers-list > :nth-child(1)').click()
  cy.get('#username').type(username);
  cy.get('#password').type(password);
  cy.get('button[type="submit"]').click();
});
