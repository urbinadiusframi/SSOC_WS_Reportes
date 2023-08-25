/// <reference types="cypress" />
import "cypress-iframe";


describe('Consulta individual por numero de radicados', () => {
  beforeEach(() => {
    cy.visit('/')
  })

  it('navbar operativo', () => {

    const colors = ['2020-01-326105']
    const colores = ['2020-01-326105','2021-01-054080', '2022-01-782401', '2022-01-929505', '2022-01-950017', '2022-01-953752', '2022-01-933539', '2022-01-944222', '2022-01-929505', '2022-01-782401', '2021-01-054080', '2020-01-526112'
      , '2020-01-526112', '2020-01-312247', '2020-01-244288', '2020-03-007687', '2018-01-466760'];

    cy.wrap(colors).each((color) => {
      cy.log(color);
      cy.get('#numeroRadicado').clear();
      cy.get('#numeroRadicado').type(color);
      cy.get(':nth-child(1) > .btn').click();
      cy.viewport('macbook-16')
      cy.get('body').then(($body) => {
        // Check if the popup exists
        if ($body.find('.swal2-popup').length > 0) {
          cy.log("No encontrado");
          cy.screenshot(`${color}-no-encontrado`);
          cy.get('.mt-4 > :nth-child(2) > .btn').click();
          cy.get('#swal2-html-container').should('have.text', 'Formulario limpiado exitosamente')
          cy.get('.swal2-confirm').click()
          // cy.get('#numeroRadicado').clear()
        } else {
          cy.log("Encontrado");
          cy.get('.mb-4.justify-content-between > :nth-child(1)').should('have.text', "Total Resultado : 1");
          cy.get('.mat-mdc-row > .cdk-column-id').should('have.text', ' 1 ')
          cy.get('.cdk-column-detalle > .btn').click()
          cy.get("[id^='mat-mdc-dialog-']").then(($dialogs) => {
            const currentDialogId = "#" + $dialogs.attr("id");
            cy.log("Current dialog ID: " + currentDialogId);
            cy.get(currentDialogId + ' > div > div > app-detail-radicado > section > app-header > nav > div > span > h2').should('have.text', ' Detalle del radicado ')
            // cy.get(currentDialogId + " > div > div > app-detail-radicado > section > mat-dialog-content").scrollTo("bottom");

            cy.document().then((doc) => {
              doc.body.classList.add("cypressHideUI");
            });
            cy.wait(1000);
            cy.get(currentDialogId + ' > div > div > app-detail-radicado')
              .then(($element) => {
                let width1 = $element.width();
                let heigh1 = $element.height();
                cy.log("tamaños " + width1 + ", " + heigh1);
                const { width, height } = $element[0].getBoundingClientRect();
                cy.log("BoundingClientRect " + width + ", " + height);
                cy.wait(1000);
                cy.get(currentDialogId + ' > div > div > app-detail-radicado > section > mat-dialog-content').scrollTo("bottom");
                cy.get(currentDialogId + ' > div > div > app-detail-radicado').screenshot(`${color}-detalle-radicado`, {
                  capture: 'viewport'
                });
              });
            // cy.get(currentDialogId + ' > div > div > app-detail-radicado > section > mat-dialog-content > div:nth-child(1)').scrollIntoView().screenshot(`${color}-detalle-radicado`);
            // cy.get(currentDialogId + ' > div > div > app-detail-radicado > section > mat-dialog-content > div:nth-child(2)').scrollIntoView().screenshot(`${color}-detalle-radicado`);
            // cy.get(currentDialogId + ' > div > div > app-detail-radicado > section > mat-dialog-content > div:nth-child(3)').scrollIntoView().screenshot(`${color}-detalle-radicado`);
            // cy.get(currentDialogId + ' > div > div > app-detail-radicado > section > mat-dialog-content > div:nth-child(4)').scrollIntoView().screenshot(`${color}-detalle-radicado`);
            // cy.get(currentDialogId + " > div > div > app-detail-radicado > section > mat-dialog-actions > button").click();
            // cy.get(currentDialogId+' > div > div > app-detail-radicado > section > mat-dialog-actions > button').click();
            // cy.get('.mt-4 > :nth-child(2) > .btn').click()
            // cy.get('#swal2-html-container').should('have.text', 'Formulario limpiado exitosamente')
            // cy.get('.swal2-confirm').click()
          });
        }
      });
    });
  })
})
