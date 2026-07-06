package opstree.common

class StaticCodeAnalysis implements Serializable {

    def steps

    StaticCodeAnalysis(steps) {
        this.steps = steps
    }

    def execute(Map config = [:]) {

        def scannerHome = steps.tool(config.scanner ?: "SonarScanner")

        steps.stage("Static Code Analysis") {

            steps.withSonarQubeEnv(config.sonar_server ?: "sonarqube") {

                steps.sh """
                    ${scannerHome}/bin/sonar-scanner \
                    -Dsonar.projectKey=${config.projectKey} \
                    -Dsonar.projectName=${config.projectName} \
                    -Dsonar.sources=${config.sources ?: "."} \
                    -Dsonar.sourceEncoding=UTF-8
                """
            }
        }
    }
}
