# Git Guide

## 1. First Clone
1. Open any terminal and navigate to the location where you want to save this project locally.
2. Once there, type `git clone https://github.com/Pepeeeeeeeeee/HalmaMaven.git` into the terminal.
3. You should now have the project stored locally.
4. If this didn’t work, try initializing Git first by typing `git init` before attempting to clone the repository again.

## 2. Creating Branches
1. Initialize Git (if not already initialized) by typing `git init`.
2. Create a new branch and switch to it using `git switch -c name_of_branch`.
3. Display all available branches (both local and remote) with `git branch -a`.
4. Push your branch to the repository and set it as a remote branch using `git push --set-upstream origin name_of_branch`.

## 3. Push into Repository
1. Add any newly created or modified files by typing `git add .`.
2. Commit your changes with a message by using `git commit -m "commit message"`.  
   (The message should describe the changes, e.g., `"Added a class"`, `"Fixed a bug"`, `"Changed a method"`).
3. Push your changes into the repository using `git push`.

## 4. Pull Requests (Ignore This for Now)
1. Pull requests are almost the same as merge requests in GitLab and work similarly.
2. **Please do not merge your branch into `main` by yourself.**  
   Have at least one person review the code before merging.

## 5. Pull from Repository
1. Pull the latest changes from the `main` branch using `git pull origin main`.
