interface Info {
    type: number,
    color: number,
    name: number
}

function countMatches(items: string[][], ruleKey: string, ruleValue: string): number {
    const info: Info = {
        type: 0,
        color: 1,
        name: 2
    };

    return items.reduce((count: number, item: string[]) =>
            item[info[ruleKey]] === ruleValue ? count + 1 : count
        , 0);
}
