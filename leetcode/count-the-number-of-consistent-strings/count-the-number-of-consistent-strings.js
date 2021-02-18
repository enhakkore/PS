/**
 * @param {string} allowed
 * @param {string[]} words
 * @return {number}
 */
const countConsistentStrings = function(allowed, words) {
    const charsOfAllowed = {};
    [...allowed].forEach(char => charsOfAllowed[char] = true);
    
    const numberOfConsistentStrings = { count : 0 };
    
    words.forEach(word => {
        let isConsistent = true;
        
        for(let c of word) {
            isConsistent = isConsistent & !!charsOfAllowed[c];
        }
        
        if(isConsistent) numberOfConsistentStrings.count++;
    });
    
    return numberOfConsistentStrings.count;
};
