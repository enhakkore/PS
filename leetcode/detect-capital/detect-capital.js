/**
 * @param {string} word
 * @return {boolean}
 */
const detectCapitalUse = function(word) {
    let result = true
    // 첫 번째 문자가 대문자인 경우
        // 두 번째 문자가 소문자인 경우 마지막까지 소문자 이어야 한다.
        // 두 번째 문자가 대문자인 경우 마지막까지 대문자 이어야 한다.
    // 첫 번째 문자가 소문자인 경우 모든 문자가 소문자이어야 한다.

    if(isCapital(word, 0)){
        if(isCapital(word, 1)){
            for(let idx = 2 ; idx < word.length ; idx++){
                if(!isCapital(word, idx)){
                    result = false
                    break
                }
            }
        } else {
            for(let idx = 2 ; idx < word.length ; idx++){
                if(isCapital(word, idx)){
                    result = false
                    break
                }
            }
        }
    } else {
        for(let idx = 1 ; idx < word.length ; idx++){
            if(isCapital(word, idx)){
                result = false
                break
            }
        }
    }

    return result
};

const isCapital = (str, index) => {
    let result = false
    if(str.charAt(index) >= 'A'.charAt(0) && str.charAt(index) <= 'Z'.charAt(0))
        result = true

    return result
};
