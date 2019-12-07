//============================================================================
// Name        : ex5.cpp
// Author      : Lidong Li
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <fstream>
#include <malloc.h>
using namespace std;

//node structure

struct node{

char character;

int count;

node *left;

node *right;

};

//BTree class

class BTree

{

node *root;

public:

//constructor

Btree() {

root=NULL;

}

//create new node

struct node *newNode(char key)

{

struct node *temp = (struct node *)malloc(sizeof(struct node));

temp->character = key;

temp->count=1;

temp->left = temp->right = NULL;

return temp;

}

//insert operation

struct node* insert(struct node* node,char character)

{

/* If the tree is empty, return a new node */

if (node == NULL)

return newNode(character);

/* Otherwise, recur down the tree */

if (character < node->character)

node->left =insert(node->left,character);

else if (character > node->character)

node->right=insert(node->right,character);

else

node->count+=1;

return node;

}

//inorder traversal

void inorder( struct node *root)

{

if( root!=NULL )

{

inorder( root->left);

cout<<"\n"<<root->character<<" : "<<root->count;

inorder( root->right);

}

}

};

int main()

{

BTree bt;

struct node *root = NULL;

ifstream file;

file.open("test.txt");

char ch;

int i=0;

//insert the character

/*root=bt.insert(root,'c');

bt.insert(root,'a');

bt.insert(root,'d');

bt.insert(root,'a');

bt.insert(root,'b');

bt.insert(root,'c');

bt.insert(root,'d');

bt.insert(root,'a');

bt.insert(root,'a'); */

if(!file){

cout<<"\nFile not found";

return 1;

}

while(file)

{

file>>ch;

if(ch>='a'&& ch<='z' || ch>='A' && ch<='Z')
{

if(i==0)

root=bt.insert(root,ch);

bt.insert(root,ch);

i++;

}

}

bt.inorder(root);

return 0;

}
