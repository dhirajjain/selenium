pipeline{
  agent any
      stages{
        stage("One"){
          steps{
            echo 'Hi, this is Dheeraj learning jenkins pipeline'
               }
        }
         stage("Two"){
          steps{
                input('Do you weant to continue?')
               }
        }
         stage("Three"){
           when{
             not{
                 branch "master"
             }
           }
            steps{
               echo "Hello"
            }
        }
        stage("Four"){
          parallel{
            stage('Unit test'){
              steps{
                echo "Running the unit test....."
                    }
                 }
            stage('Integration test'){
              agent{
                docker{
                    reuseNode false
                    image 'ubuntu'  
                    }
                  }
              steps{
                  echo 'Running the integration test.....' 
                   }
                }
             }
          }    
      } 
}
 
