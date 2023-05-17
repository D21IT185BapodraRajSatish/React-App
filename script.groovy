def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-d21it185rajbapodra', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t d21it185rajbapodra/react_weather_app:1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push d21it185rajbapodra/react_weather_app:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this