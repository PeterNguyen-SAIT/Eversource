    <template>

      <div id="app">
        
            <nav class="navbar navbar-expand-sm navbar-light bg-success  font-weight-bold ">
              <div class="navbar-nav mr-auto">
                <li class="nav-item">
                  <a href="/" class="nav-link">
                  <font-awesome-icon icon="home" /> Eversource</a>
                  </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Products </a>
                      <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="vegetable">Vegetables</a>
                        <a class="dropdown-item" href="#">Fruits</a>
                        <a class="dropdown-item" href="#">Eggs</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">More</a>
                      </div>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link " href="./online_order">Online Order</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link " href="#">Events</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link " href="#">Contact</a>
                  </li>
                </div>
                <div class="navbar-nav ml-auto">
                  <li class="nav-item">
              <a href="/register" class="nav-link">
                <font-awesome-icon icon="user-plus" /> Sign Up
              </a>
            </li>
            <li class="nav-item">
              <a href="/login" class="nav-link">
                <font-awesome-icon icon="sign-in-alt" /> Login
              </a>
            </li>
          </div>


        
        </nav>
       

        
      </div>
      
     
</template>
    <script>
    export default { name: 'App' }
    </script>
    <style>
      #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }
    </style>
