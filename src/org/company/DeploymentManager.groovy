package org.company

class DeploymentManager {

    def steps
    String environment
    String deploymentType

    DeploymentManager(def steps, String environment, String deploymentType) {
        this.steps = steps
        this.environment = environment
        this.deploymentType = deploymentType
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
            return
        }

        if(deploymentType == "rolling") {
            steps.echo "Using Rolling Deployment Strategy"
            steps.echo "Updating servers one by one"
        }
        else if(deploymentType == "blue-green") {
            steps.echo "Using Blue-Green Deployment Strategy"
            steps.echo "Deploying to GREEN environment"
            steps.echo "Switching traffic from BLUE to GREEN"
        }
        else {
            steps.echo "Invalid deployment type"
        }
    }

    def rollback() {
        steps.echo "Rollback ${environment}"
    }
}
