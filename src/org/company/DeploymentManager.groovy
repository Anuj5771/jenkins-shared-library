package org.company

class DeploymentManager {

    String environment

    DeploymentManager(String environment) {
        this.environment = environment
    }

    def validate() {
        println "Validating deployment for ${environment} environment"
    }

    def deploy() {

        if(environment == "dev") {
            println "Deploying DEV"
        }
        else if(environment == "staging") {
            println "Deploying STAGING"
        }
        else if(environment == "prod") {
            println "Deploying PROD"
        }
        else {
            println "Invalid environment"
        }
    }

    def rollback() {
        println "Rollback ${environment}"
    }
}
