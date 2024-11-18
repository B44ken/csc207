class ChartDataRepository {
    constructor() {
        this.quickChartUrl = 'https://quickchart.io/chart';
    }

    /**
     * Generates a line chart URL based on the provided configuration.
     *
     * @returns {Promise<string>} - URL of the generated chart image.
     */
    async generateLineChartUrl() {
        try {
            // Define chart configuration based on provided QuickChart API example
            const chartConfig = {
                    type: 'line',
                    data: {
                labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July'],
                datasets: [
                {
                    label: 'My First dataset',
                            backgroundColor: 'rgb(255, 99, 132)',
                        borderColor: 'rgb(255, 99, 132)',
                        data: [93, -29, -17, -8, 73, 98, 40],
                    fill: false,
                },
                {
                    label: 'My Second dataset',
                            backgroundColor: 'rgb(54, 162, 235)',
                        borderColor: 'rgb(54, 162, 235)',
                        data: [20, 85, -79, 93, 27, -81, -22],
                    fill: false,
                },
                    ],
            },
            options: {
                title: {
                    display: true,
                            text: 'Chart.js Line Chart',
                },
            },
            };

            // Send POST request to QuickChart API
            const response = await fetch(this.quickChartUrl, {
                    method: 'POST',
                    headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ chart: chartConfig }),
            });

            // Check if the response was successful
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }

            // Parse and return the URL from the response
            const result = await response.json();
            return result.url;

        } catch (error) {
            console.error('Error generating chart URL:', error);
            throw error;
        }
    }
}

module.exports = ChartDataRepository;