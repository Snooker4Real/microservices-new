pipeline {
    agent any

    environment {
    	mavenHome = tool 'jenkins-maven'
    }

    tools {
        jdk 'java-17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from the Git repository
                checkout scm
            }
        }

        stage('Branch Name Check') {
            steps {
                script {
                    // Check if the branch name follows a specific pattern
                    def branchName = env.BRANCH_NAME
                    if (!branchName.matches('feature/.*')) {
                        error "Branch name should start with 'feature/'"
                    }
                }
            }
        }

        stage('Build') {
            steps {
                bat "mvn clean install -DskipTests"
            }
        }

        stage('Test') {
            steps{
                bat "mvn test"
            }
        }

        stage('Deploy') {
            when {
                // Specify conditions to deploy (optional)
                expression {
                    return env.BRANCH_NAME == 'main'
                }
            }
            steps {
                // Deployment steps for the main branch
                sh 'echo "Deploying to production"'
                bat "mvn jar:jar deploy:deploy"
            }
        }
    }

    post {
        always {
            echo "I will always get executed"
        }
        success {
            echo "I will be executed if the build is success"
        }
        failure {
            echo "I will be executed if the build fails"
        }
        unstable {
            echo "I will be executed if the build is unstable"
        }
    }
}
