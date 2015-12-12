      // ********** Lab 4c - #2 **********
      //  Enter information from an unsorted ASCII text file, Employees.txt
      
      // Define file scanner object
      fileScan = new Scanner(new File("Employees.txt"));
 
      while (fileScan.hasNext())
      { // begin outer while loop 
      
          // get a record from the file
          record = fileScan.nextLine();
      
          // Create Employee record Scanner objest
          recordScan = new Scanner (record);
          recordScan.useDelimiter(" ");
                    
          // take the record apart          
          while(recordScan.hasNext())
          { // begin inner while loop
                   
              first = recordScan.next();
              middle = recordScan.next();
              last = recordScan.next();
              // Convert payRate and hoursWorked from strings to doubles
              payRate = Double.parseDouble(recordScan.next());
              hoursWorked = Double.parseDouble(recordScan.next());
           
              // Create an Employee object
              emp[count] = new Employee(first, middle, last, payRate, hoursWorked); 
              
              // Display the Employee object
              System.out.println(emp[count]);
              System.out.println("Pay rate = " + emp[count].getPayRate() + " Hours = "  
                 + emp[count].getHoursWorked() + " Gross Pay = " + emp[count].calculatePay());
                         
              // increment count for next employee object
              count++;
             
          } // end of inner while loop
   
      } // end outer while loop