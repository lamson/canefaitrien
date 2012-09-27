Team CaNeFaitRien
======

What you need to do for now:

http://gitreal.codeschool.com/levels/1

http://try.github.com/levels/1/challenges/1
  
https://help.github.com/categories/54/articles  

  YouTube: Git Tutorial: http://www.youtube.com/watch?v=vaNGbk6HN9Y&list=UU3pzbTVgo01qT-maRchkbIg&index=8&feature=plcp  
  
Work through github bootcamp to setup git! link here:  
https://help.github.com/categories/54/articles  
  
  
Below is just the summary of some useful git command  
  
    
// clone the repository onto your computer  
$ cd [directory]  
$ mkdir canefaitrien  
$ cd canefaitrien  
$ git clone https://github.com/lamson6592/canefaitrien.git  
  
OR  
  
get on GitHub, click "Clone to my Mac" (for Mac), or download the zip file
  
// create a remote named 'origin' pointing at the repo on GitHub  
$ git remote add origin https://github.com/lamson6592/canefaitrien.git    
  


DAILY TASKS:  
  
After you modified files  
// to check what's changed since last commit    
$ git status  
  
// add each modified file   
$ git add [file-name]  

// add all new or modified files  
$ git add --all  
  
// when happy with your job and added all modified files  
$ git commit -m "message goes here"  
  
NOTE: commit often is good!  
  
  
// create new branch & switch to that branch  
$ git checkout -b [newbranch]  
  
// show list of branches  
$ git branch  -a
  
// switch to branch  
$ git checkout [newbranch] 
  
  
// when ready to merge branch, switch to master branch  
$ git checkout master  
  
// pull latest version  
$ git pull  
  
// merge branch to master in local repository  
$ git merge [newbranch]  
  
// delete a branch  
$ git branch -d [branch]
 
// push to master  
$ git push origin master  
   
   OR

$ git push  

// change back to how a file was at the last commit  
$ git checkout -- [target]


-------
git log  
git reflog  
git show  
gitk  
  
git checkout [filename]		return the previously committed file  
  
git commit -am "message"		add + commit together, save time  
  
--- reset  
git reflog 					then pick a commit with the [commit] id  
git reset --hard [commit]		move that commit HEAD to top  
git push --force				force update  
  
git reset HEAD [filename] 		unstage  
  
git mergetool				UI window pops up, edit, save  
vim [filename]				merge manually  
  
  
  BRANCHING  
git branch -a    
git checkout -b [newfeature branch]		create & switch to new branch  
  
git push origin [newfeature branch]		create branch on github then push  
  
git checkout master					switch back to master branch  
git merge [newfeature branch]			merge [newfeature branch] to master  
  
git branch -d [newfeature branch]			delete branch on local  
git push origin :[newfeature branch]		delete branch on github  
  
