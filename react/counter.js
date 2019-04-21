class Counter extends React.Component {
    constructor(props) {
      super(props);
  
      this.state = {
        count: props.count || 0
      };
  
      this.updateCount = this.updateCount.bind(this);
    }
  
    updateCount(increment) {
      const { count } = this.state;
  
      if (increment) {
        this.setState({
          count: count + 1
        });
      } else {
        this.setState({
          count: count - 1
        });
      }
    }
  
    render() {
      const { count } = this.state;
  
      return React.createElement(
        "div",
        null,
        React.createElement("p", null, "The current count is ", count),
        React.createElement(
          "button",
          {
            type: "button",
            onClick: () => {
              return this.updateCount(true);
            }
          },
          "Increment"
        ),
        React.createElement(
          "button",
          {
            type: "button",
            onClick: () => {
              return this.updateCount(false);
            }
          },
          "Decrement"
        )
      );
    }
  }
  
  export default Counter;