# Minimum Spanning Tree
## Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a weighted, undirected and connected graph of <strong>V</strong> vertices and <strong>E</strong> edges. The task is to find the sum of weights of the edges of the Minimum Spanning Tree. Given<span style="font-size: 18pt;"> </span></span><span style="font-size: 18pt;"><span style="background-color: #ffffff; color: rgba(0, 0, 0, 0.87); font-family: sofia-pro;">&nbsp;<span style="font-size: 14pt;">adjacency list adj as input parameters .&nbsp;</span></span><span style="background-color: #ffffff; color: rgba(0, 0, 0, 0.87); font-family: sofia-pro; font-size: 14pt;">Here adj[i] contains vectors of size 2, where the first integer in that vector denotes the end of the edge and the second integer denotes the edge weight.</span></span></p>
<p>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:
</strong>3 3
0 1 5
1 2 3
0 2 1</span>
<img src="https://media.geeksforgeeks.org/img-practice/PROD/addEditProblem/700343/Web/Other/064ccfb5-e351-4908-a660-b228a091eb47_1685086606.png" alt="">
<span style="font-size: 18px;"><strong>Output:</strong>
4
<strong>Explanation</strong>:</span>
<img style="height: 207px; width: 288px;" src="https://media.geeksforgeeks.org/img-practice/PROD/addEditProblem/700343/Web/Other/64f692e2-1acf-4515-8f46-516521cf0bab_1685086607.png" alt="">
<span style="font-size: 18px;">The Spanning Tree resulting in a weight
of 4 is shown above.</span>
</pre>
<p><span style="font-size: 18px;"><strong>Example 2:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:
</strong>2 1
0 1 5</span>
<img src="https://media.geeksforgeeks.org/img-practice/PROD/addEditProblem/700343/Web/Other/944e4620-f860-4e62-aa2a-086f31e142cb_1685086607.png" alt="">
<span style="font-size: 18px;"><strong>Output:</strong>
5
<strong>Explanation</strong>:
Only one Spanning Tree is possible
which has a weight of 5.</span>
</pre>
<p>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Your task:</strong><br><span style="font-size: 14pt;"><span style="color: rgba(0, 0, 0, 0.87); font-family: sofia-pro; background-color: #ffffff;">Since this is a functional problem you don't have to worry about input, you just have to complete the function&nbsp;</span><span style="box-sizing: inherit; font-weight: bolder; color: rgba(0, 0, 0, 0.87); font-family: sofia-pro; background-color: #ffffff;">spanningTree()</span><span style="color: rgba(0, 0, 0, 0.87); font-family: sofia-pro; background-color: #ffffff;">&nbsp;which takes a number of vertices V</span><span style="box-sizing: inherit; font-weight: bolder; color: rgba(0, 0, 0, 0.87); font-family: sofia-pro; background-color: #ffffff;">&nbsp;</span><span style="color: rgba(0, 0, 0, 0.87); font-family: sofia-pro; background-color: #ffffff;">and</span><span style="box-sizing: inherit; font-weight: bolder; color: rgba(0, 0, 0, 0.87); font-family: sofia-pro; background-color: #ffffff;">&nbsp;</span><span style="color: rgba(0, 0, 0, 0.87); font-family: sofia-pro; background-color: #ffffff;">an adjacency list adj as input parameters and returns an integer denoting the sum of weights of the edges of the Minimum Spanning Tree. Here adj[i] contains vectors of size 2, where the first integer in that vector denotes the end of the edge and the second integer denotes the edge weight.</span></span><br></span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(ElogV).<br><strong>Expected Auxiliary Space:&nbsp;</strong>O(V<sup>2</sup>).</span><br>&nbsp;</p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>2 </span> <span style="font-size: 18px;">≤</span> <span style="font-size: 18px;"> V</span> <span style="font-size: 18px;">≤</span> <span style="font-size: 18px;"> 1000<br>V-1 </span><span style="font-size: 18px;">≤</span> <span style="font-size: 18px;"> E </span> <span style="font-size: 18px;">≤</span> <span style="font-size: 18px;"> (V*(V-1))/2<br>1 </span> <span style="font-size: 18px;">≤</span> <span style="font-size: 18px;"> w </span> <span style="font-size: 18px;">≤</span> <span style="font-size: 18px;"> 1000<br>The graph is connected and doesn't contain self-loops &amp; multiple edges.</span></p></div>