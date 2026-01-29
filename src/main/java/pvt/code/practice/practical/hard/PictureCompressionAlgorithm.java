package pvt.code.practice.practical.hard;

/*

images are balck and while, square
Hover over a message to pin it
keep
You
4:49 PM
compression logic:
image, create a tree, enpty node.
divide image into 4 equal quadrants
add 4 children to the tree nodes, balnk nodes
re-divide the 4 quads into 4 more...now 16 quads..
add 4 children again...so totla 16 children...
keep doing it till the squares are of the size 2*2 in the image
add 4 children in the tree
You
4:52 PM
values will be present only in the child node initially... from matrix to ta tree.
next is the compression logic
You
4:53 PM
if all 4 nodes have same value, delete those children and put the same value to the parent node of the leaf nodes.
NOTE: values are either 0 or 1
Mohit Garg
5:00 PM
px = no of pixels in a row

for(int i=0; i++; i<px)
for(int j=0; j++; j<px)
output[i][j] = operator(image1[i][j], image2[i][j])
You
5:07 PM
have a method with inputs as 2 trees, and return a final tree

before compression
    N/A                 ||          N/A
N/A     ,   N/A           ||  N/A         ,   N/A
1 1 0 1 , 0 0 0 0       ||  1 1 1 1   , 0 0 0 0

after compression
    N/A                 ||          N/A
N/A     ,   0           ||      1        ,   0
1 1 0 1 ,

//output[i][j] = operator(0, 1)
//output[i][j] = operator(null, 1)//not applicable

FINAL OUTPUT (without compression, based on operator())
    N/A
N/A     ,   0
1 1 0 1 ,

FINAL OUTPUT (with compression)
    N/A
N/A     ,   0
1 1 0 1 ,

 */
public class PictureCompressionAlgorithm {
    public static void main(String[] args) {

        // receive 2 input trees that are already compressed...tree1 and tree2
        // traverse tree1 and temporarily store it in variable1
            //
        // traverse tree2 and temporarily store it in variable2
        // pass variable 1 and 2 into operator() ... returns output value
        // construct final output tree with returned value
        // compress final output tree

    }
}
