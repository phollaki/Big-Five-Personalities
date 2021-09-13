let options = {};

const buildCanvas = function (userData, compare) {
  return (options = {
    exportEnabled: true,
    animationEnabled: true,
    title: {
      text: "Your and Other students data",
    },
    subtitles: [
      {
        text: "",
      },
    ],
    axisX: {
      title: "Personalities",
    },
    axisY: {
      title: "Value",
      titleFontColor: "#000000",
      lineColor: "#000000",
      labelFontColor: "#000000",
      tickColor: "#000000",
      includeZero: true,
    },
    axisY2: {
      title: "Value",
      titleFontColor: "#000000",
      lineColor: "#000000",
      labelFontColor: "#000000",
      tickColor: "#000000",
      includeZero: true,
    },
    toolTip: {
      shared: true,
    },
    data: [
      {
        type: "column",
        name: "Your data",
        showInLegend: true,
        yValueFormatString: "#,##0.# ",
        color: "#36c996",
        dataPoints: [
          { label: "Openness", y: userData[0] },
          { label: "Agreeableness", y: userData[1] },
          { label: "Extroversion", y: userData[2] },
          { label: "Neuroticism", y: userData[3] },
          { label: "Conscientiousness", y: userData[4] },
        ],
      },
      {
        type: "column",
        name: "Others data",
        axisYType: "secondary",
        showInLegend: true,
        yValueFormatString: "#,##0.#",
        dataPoints: [
          { label: "Openness", y: compare[0] },
          { label: "Agreeableness", y: compare[1] },
          { label: "Extroversion", y: compare[2] },
          { label: "Neuroticism", y: compare[3] },
          { label: "Conscientiousness", y: compare[4] },
        ],
      },
    ],
  });
};
export default buildCanvas;
