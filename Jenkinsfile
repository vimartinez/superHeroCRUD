pipeline{
  agent any
  tools { 
        maven 'Maven 3.3.9' 
        jdk 'jdk8' 
    }
  stages{
    stage("build"){
      steps{
        echo "building the application"
        sh 'mvnw package && java -jar target/superHeroCRUD-0.1.0.jar'
      }
    }
    stage("test"){
      steps{
        echo "testing the application"
      }
    }
    stage("deploy"){
      steps{
        echo "deploing the application"
      }
    }
  }
}
