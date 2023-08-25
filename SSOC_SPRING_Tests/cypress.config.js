const { defineConfig } = require("cypress");

module.exports = defineConfig({
  viewportWidth: 1280,
  viewportHeight: 720,
  video: true,
  videoUploadOnPasses: false,
  screenshotsFolder: "cypress/screenshots",
  videosFolder: "cypress/videos",
  chromeWebSecurity: false,
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
      on('task', {
        log(message) {
          console.log(message)
          return null
        }
      })
    },
  },
  
});
