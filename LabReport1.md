cd command: <br>
1. <img width="171" alt="Lab1cd1" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/ebde7e21-8722-4562-aacd-b3d6bd8ef56d"> <br>
- The working directory when the command ran was /home <br>
- I got this output because when we don't use an argument for the cd command, you aren't changing the directory which means we stay in the home directory <br>
- This is not an error <br>
2. <img width="261" alt="Lab1cd2" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/f842eb45-9d40-482e-9f82-b31ccb657fc1"> <br>
- The working directory when the command ran was /home/lecture1 <br>
- I got this output because when we use cd with the argument lecture1 (directory) we are changing the working directory to /home/lecture1 which is why we now see "/lecture1" after the "~" which means home directory <br>
- This is not an error <br>
3. <img width="318" alt="Lab1cd3" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/5787ae5a-eb6f-401f-bae0-0ac075ff16c1"> <br>
- The working directory when the command ran was /home/lecture1 <br>
- I got this output because when we use cd with the argument README (a file) we aren't chaning the working directory since a directory stores other files but README is just a file which does not store other files, thus getting the output that README is not a directory <br>
- This is an error because we are trying to use a file as argument which is not possible for the cd command since we need a directory as an argument if we are trying to change directory <br>

ls command: <br>
1. <img width="174" alt="Lab1ls1" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/4da316d2-88fc-408e-85ec-ec63abaeae24"> <br>
- The working directory when the command ran was /home <br>
- I got this output because the ls command just lists the files and folders in the current directory we are in which is /home so the output just lists lecture1 because it is the only folder that is in /home and there are no other files <br>
- This is not an error <br>
2. <img width="372" alt="Lab1ls2" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/45bc3a6f-077c-419a-bc33-0ad4b20639ef"> <br>
- The working directory when the command ran was /home <br>
- I got this output because the ls command is listing the files in lecture1 which are the ones that are listed. Messages is bolded because it is another directory that we can go to which contains more files <br>
- This is not an error <br>
3. <img width="480" alt="Lab1ls3" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/ab3e1516-7878-40cb-b56a-19bb9da2f292"> <br>
- The working directory when the command ran was /home <br>
- I got this output because there are no other files in README unlike lecture1 which we saw from the example above where there were other files within the lecture1 directory <br>
- This is an error because the ls command was not able to list any files within README since there exists no files <br>

cat command:  <br>
1. <img width="267" alt="Lab1cat1" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/2c8ed807-8f96-4ae6-bfab-1be711b91d99">  <br>
- The working directory when the command ran was /home/lecture1 <br>
- I got this output because the cat command without any arguments will read the terminal since there are no files to read <br>
- This is not an error
2. <img width="355" alt="Lab1cat2" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/0e6ac8db-ff90-4333-82e7-40c23a2734e0">  <br>
- The working directory when the command ran was /home/lecture1 <br>
- I got this output because the cat command is used to read files but the argument we used was a directory which won't be able to print its contents <br>
- This is an error because we are trying to use cat to print out the directory messages but cat is unable to print its contents  <br> 
3. <img width="722" alt="Lab1cat3" src="https://github.com/colinsutedja/cse15l-lab-reports/assets/156348859/874a588f-daeb-46cd-975f-3b045a179d22">  <br>
-  The working directory when the command ran was /home/lecture1 <br>
- I got this output because the cat command is reading both the files of Hello.java and README so it combine (concatenate) both the files when printing their contents  <br>
- This is not an error  <br>
