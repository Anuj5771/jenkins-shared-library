package org.company

class DeploymentManager {

    String environment

    DeploymentManager(String environment) {
        this.environment = environment
    }

    def validate() {
        echo "Validating deployment for ${environment}"
    }

    def deploy() {

        if(environment == "dev") {
            echo "Deploying DEV"
        }
        else if(environment == "staging") {
            echo "Deploying STAGING"
        }
        else if(environment == "prod") {
            echo "Deploying PROD"
        }
        else {
            echo "Invalid environment"
        }
    }

    def rollback() {
        echo "Rollback ${environment}"
    }
}
