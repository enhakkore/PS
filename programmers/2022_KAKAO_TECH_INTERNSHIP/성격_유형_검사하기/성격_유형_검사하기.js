const index = {
    R: 0,
    T: 0,
    C: 0,
    F: 0,
    J: 0,
    M: 0,
    A: 0,
    N: 0,
};

const solution = (survey, choices) => {
    let answer = "";
    const length = survey.length;

    for (let i = 0 ; i < length ; i++) {
        const s = survey[i];
        const c = choices[i];

        let surveyTarget = "";
        let point = 0;

        if (c > 4) {
            surveyTarget = s.charAt(1);
            point = c - 4;

        } else if(c < 4) {
            surveyTarget = s.charAt(0);
            point = 4 - c;
        }

        if (c !== 4) {
            index[`${surveyTarget}`] += point;
        }
    }

    const indexEntries = Object.entries(index);

    for (let i = 0 ; i < 8 ; i += 2 ) {
        const [key1, value1] = indexEntries[i];
        const [key2, value2] = indexEntries[i+1];

        if ( value1 > value2) {
            answer += key1;
        } else if ( value1 < value2) {
            answer += key2;
        } else {
            answer += key1 > key2 ? key2 : key1;
        }
    }

    return answer;
}
