// ***********************************************************
// This example support/e2e.js is processed and
// loaded automatically before your test files.
//
// This is a great place to put global configuration and
// behavior that modifies Cypress.
//
// You can change the location of this file or turn off
// automatically serving support files with the
// 'supportFile' configuration option.
//
// You can read more here:
// https://on.cypress.io/configuration
// ***********************************************************

// Import commands.js using ES2015 syntax:
import './commands'

// Alternatively you can use CommonJS syntax:
// require('./commands')

const baseUrl = 'https://8000-luisurbm-factura-2wsx40kg9ct.ws-us103.gitpod.io';
const baseUrlSSOCDello = 'https://cpd-cp4badllo.apps.ssrhv-ops01.supersociedades.local/bawaut/ProcessPortal';
const baseUrlSSOCPreConsultaMigrados = 'https://dev-servicios-dmz.supersociedades.gov.co:1443/ConsultaMigrados/';

Cypress.config('baseUrl', baseUrlSSOCPreConsultaMigrados);