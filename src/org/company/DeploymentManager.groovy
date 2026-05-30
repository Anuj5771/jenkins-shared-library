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
        steps.sh 'docker ps'
    }

    def deploy() {

        if(environment == "dev") {
            steps.sh 'docker build -t attendance-dev .'
            steps.sh 'docker run -d -p 8081:8081 --name attendance-dev-container attendance-dev'
        }
        else if(environment == "staging") {
            steps.sh 'docker build -t attendance-staging .'
            steps.sh 'docker run -d -p 8081:8081 --name attendance-staging-container attendance-staging'
        }
        else if(environment == "prod") {
            steps.sh 'docker build -t attendance-prod .'
            steps.sh 'docker run -d -p 8081:8081 --name attendance-prod-container attendance-prod'
        }
        else {
            steps.sh 'docker ps'
            return
        }

        if(deploymentType == "rolling") {
            steps.sh 'docker ps'
        }
        else if(deploymentType == "blue-green") {
            steps.sh 'docker ps'
            steps.sh 'docker images'
        }
        else {
            steps.sh 'docker ps'
        }
    }

    def rollback() {
        steps.sh 'docker stop attendance-prod-container || true'
        steps.sh 'docker rm attendance-prod-container || true'
    }
}
