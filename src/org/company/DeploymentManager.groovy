package org.company

class DeploymentManager {

    String environment

    // Constructor
    DeploymentManager(String environment) {
        this.environment = environment
    }

    // Validate method
    def validate() {
        println "Validating deployment for ${environment} environment"
    }

    // Deploy method
    def deploy() {

        if(environment == "dev") {
            println "Deploying application to DEV environment"
        }

        else if(environment == "staging") {
            println "Deploying application to STAGING environment"
        }

        else if(environment == "prod") {
            println "Deploying application to PRODUCTION environment"
        }

        else {
            println "Invalid Environment"
        }
    }

    // Rollback method
    def rollback() {
        println "Rollback deployment for ${environment}"
    }
}
