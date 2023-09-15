pipeline {
    agent any

    stages {
        stage('hello') {
            steps {
                // Checkout the code from the Git repository
                echo "hello world"
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
