pipeline {
    agent any

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
                // Build the application using Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests (replace with your testing commands)
                sh 'mvn test'
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
            }
        }
    }

    post {
        failure {
            // Actions to perform in case of failure (optional)
            echo 'Build failed! Sending a notification.'
            // Send notifications (email, Slack, etc.)
        }
    }
}
