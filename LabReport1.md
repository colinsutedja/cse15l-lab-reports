cd command: <br>
1. <img width="171" alt="Lab1cd1" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/ebde7e21-8722-4562-aacd-b3d6bd8ef56d"> <br>
- The working directory when the command ran was `/home` <br>
- I got this output because when we don't use an argument for the cd command, we will change directory back to `\home`. For example if we are in the path `/home/lecture1/messages` and use the cd command, we will just go back to the `/home` directory. <br>
- This is not an error <br>
2. <img width="261" alt="Lab1cd2" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/f842eb45-9d40-482e-9f82-b31ccb657fc1"> <br>
- The working directory when the command ran was `/home/lecture1` <br>
- I got this output because when we use cd with the argument lecture1 (a directory) we are changing the working directory to `/home/lecture1` which is why we now see `/lecture1` after the "~" which means home directory <br>
- This is not an error <br>
3. <img width="318" alt="Lab1cd3" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/5787ae5a-eb6f-401f-bae0-0ac075ff16c1"> <br>
- The working directory when the command ran was `/home/lecture1` <br>
- I got this output because when we use cd with the argument README (a file) we aren't chaning the working directory since a directory stores other files but README is just a file which does not store other files, thus getting the output that README is not a directory <br>
- This is an error because we are trying to use a file as argument which is not possible for the cd command since we need a directory as an argument if we are trying to change directory <br>

ls command: <br>
1. <img width="373" alt="Lab1ls1" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/11c30736-5de7-4c6c-a1b7-e375c2267ecd"> <br>
- The working directory when the command ran was `/home/lecture1` <br>
- I got this output because the ls command is listing the files and folders in the given path `/home/lecture1` which is why our output gives us 3 files and 1 folder (messages is bolded indicating that it is a folder) <br>
- This is not an error <br>
2. <img width="357" alt="Lab1ls2" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/f5976bc9-cb3c-4d3d-846a-d4f04ec6992c"> <br>
- The working directory when the command ran was `/home/lecture1/messages` <br>
- I got this output because the ls command with the argument messages (a directory) is listing the files and folders in the given path `/home/lecture1/messages` which is why our output gives us 4 txt files that are within the messages folder <br>
- This is not an error <br>
3. <img width="320" alt="Lab1ls3" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/aa8287bf-c638-4823-bf2d-0f7399aaab3a"> <br>
- The working directory when the command ran was `/home/lecture1/README` <br>
- I got this output because the ls command with the argument README (a file) is listing the files and folders in the given path `/home/lecture1/README` and the only file in this path is README which is where we get our output <br>
- This is not an error <br>

cat command:  <br>
1. <img width="267" alt="Lab1cat1" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/2c8ed807-8f96-4ae6-bfab-1be711b91d99"> <br>
- The working directory when the command ran was `/home/lecture1` <br>
- I got this output because the cat command without any arguments will read the terminal and print whatever we type in the terminal <br>
- This is not an error
2. <img width="355" alt="Lab1cat2" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/0e6ac8db-ff90-4333-82e7-40c23a2734e0"> <br>
- The working directory when the command ran was `/home/lecture1/messages` <br>
- I got this output because the cat command is used to print the files in the given path but using the argument messages (a directory) is unable to print the contents which gives us the error message that messages/ : Is a directory <br>
- This is an error because the given path `/home/lecture1/messages` is a directory which means cat is unable to print its contents <br> 
3. <img width="328" alt="Lab1cat3" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/19b85121-cab6-473b-a933-265f8559b110"> <br>
-  The working directory when the command ran was `/home/lecture1/README` <br>
- I got this output because the cat command with the argument README (a file) will print the contents of the file README given by the path `/home/lecture1/README` <br>
- This is not an error <br>
