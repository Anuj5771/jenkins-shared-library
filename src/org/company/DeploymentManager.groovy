package org.company

class DeploymentManager {

    def steps
    String environment

    DeploymentManager(steps, String environment) {
        this.steps = steps
        this.environment = environment
    }

    def validate() {
        steps.echo "Validating deployment for ${environment}"
    }

    def deploy() {

        if(environment == "dev") {
            steps.echo "Deploying DEV"
        }
        else if(environment == "staging") {
            steps.echo "Deploying STAGING"
        }
        else if(environment == "prod") {
            steps.echo "Deploying PROD"
        }
        else {
            steps.echo "Invalid environment"
        }
    }

    def rollback() {
        steps.echo "Rollback ${environment}"
    }
}
