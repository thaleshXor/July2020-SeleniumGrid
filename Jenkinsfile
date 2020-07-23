pipeline {
  agent none
  stages{
  
    stage('STAGE GROUP NAME'){

    parallel{
      //------------------------------Stage1------------------------------
        stage('Stage1:Testing on Windows-chrome') {
          agent{
            label 'master'
          }

          environment{
            JAVA_HOME='C:/Program Files/Java/jdk1.8.0_231'
          }
          steps {
            
            echo "-------------jenkinsFile-Hardcoded messgae:::TEST STARTS On Windows Chrome -----------------"
            bat 'mvn test -Dbrowser=chrome -DosName=windows'
            
          }//steps ends
        }//stage1 ends------------------------------------------------
      
      //---------------------------------Stage2----------------------------
        stage('Stage2:Testing on Ubuntu-firefox') {
          agent{
            label 'ubuntu'
          }
   
          steps {
              echo "-------------jenkinsFile-Hardcoded messgae:::TEST STARTS on ubuntu Firefox-----------------"
              sh 'mvn test -Dbrowser=firefox -DosName=linux -e'

          }//steps ends
          
          
        }//stage2 ends------------------------------------------------      
      
    }//prallel block ends here 
    
  }//stage group ends here
      
  }//stages ends
}//pipeline ends
