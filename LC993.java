
// Time complexityu O(n)
// Space complexity O(n)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isCousins(TreeNode* root, int x, int y) {
        if (root == nullptr) {
            return false;
        }

        queue<TreeNode*> que;
        que.push(root);

        while (!que.empty()) {

            bool x_found = false;
            bool y_found = false;
            
            int n = que.size();
            for (int i=0; i < n; i++) {
                TreeNode* node = que.front();
                que.pop();

                if (node->left != nullptr && node->right != nullptr) {
                    if (node->left->val == x && node->right->val == y) {
                        return false;
                    }
                    if (node->left->val == y && node->right->val == x) {
                        return false;
                    }
                }

                if (node->val == x) {
                    x_found = true;
                }
                if (node->val == y) {
                    y_found = true;
                }

                if (node->left != nullptr) {
                    que.push(node->left);
                }
                if (node->right != nullptr) {
                    que.push(node->right);
                }

            }

            if (x_found && y_found) {
                return true;
            }
            if (x_found || y_found) {
                return false;
            }
        }

        return false;
    }
};