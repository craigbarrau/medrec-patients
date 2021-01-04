pipeline {
    agent { 
        docker { 
            image 'maven:3.3.3' 
            // 2. Reusing the node
            reuseNode true
        }
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install'
            }
        }
    }
}